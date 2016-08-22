package com.example.dllo.keepproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dllo.keepproject.R;

import java.util.Date;

/**
 * Created by dllo on 16/8/22.
 * 下拉刷新的LV
 */
public class RefreshListView extends ListView implements AbsListView.OnScrollListener {
    // 再次释放
    private final static int RELEASE_TO_REFRESH = 0;
    // 开始下拉
    private final static int PULL_TO_REFRESH = 1;
    //*正在刷新
    private final static int REFRESHING = 2;
    //*刷新完成
    private final static int DONE = 3;
    private final static int LOADING = 4;
    //广播?
    private final static int RADIO = 3;

    // 头布局
    private LinearLayout mHeadView;
    // 提示 - 请释放刷新
    private TextView mTipsTextView;
    // 上一次更新时间
    private TextView mLastUpdatedTextView;
    // 下拉的小箭头
    private ImageView mArrowImageView;
    // 进度条
    private ProgressBar mProgressBar;
    // 动画效果 下拉时 松开刷新时
    private RotateAnimation mAnimation;
    private RotateAnimation mReverseAnimation;
    // 是否当当前位置
    private boolean mIsRecored;
    // 头布局的宽高
    private int mHeadContentWidth;
    private int mHeadContentHeight;
    private int mStartY;
    // 第一个行布局的位置
    private int mFirstItemIndex;
    private int mState;

    private boolean mIsBack;
    private boolean mISRefreshable;
    // 定义了一个接口
    private OnRefreshListener mRefreshListener;

    /**
     * 自定义listview 的构造方法
     * @param context
     * @param attrs
     */
    public RefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        // 绑定布局 将布局注入
        mHeadView = (LinearLayout) LayoutInflater.from(context).
                inflate(R.layout.listview_refresh_head,null);
        // 下拉的小箭头
        mArrowImageView = (ImageView) mHeadView.findViewById(R.id.head_arrowImageView);
        // 进度条
        mProgressBar = (ProgressBar) mHeadView.findViewById(R.id.head_progressBar);
        // 提示 - 请释放刷新
        mTipsTextView = (TextView) mHeadView.findViewById(R.id.head_tipsTextView);
        // 上一次更新时间
        mLastUpdatedTextView = (TextView) mHeadView.findViewById(R.id.head_lastUpdatedTextView);
        // 将头布局放进去调用测量宽高的方法
        measureView(mHeadView);
        // 得到头部高度 宽度.
        mHeadContentHeight = mHeadView.getMeasuredHeight();
        mHeadContentWidth = mHeadView.getMeasuredWidth();
        // 将头布局隐藏起来,使用这个属性,(左,上,右,下),
        // 这里我们只需要只要设置top的值为头布局(脚布局)的高度即可“隐藏”这两个布局
        // 让头布局的高度*-1 就把它隐藏起来了.
        mHeadView.setPadding(0, -1 * mHeadContentHeight, 0, 0);
        //invalidate()是用来刷新View的，必须是在UI线程中进行工作。
        // 比如在修改某个view的显示时，调用invalidate()才能看到重新绘制的界面。
        // invalidate()的调用是把之前的旧的view从主UI线程队列中pop掉。
        // (刷新头布局)
        mHeadView.invalidate();
        // 为listview添加头布局
        // 第三个参数的意思是控制头布局是否能被selected(选择)到
        addHeaderView(mHeadView, null, false);
        //为头布局设置滚动事件
        setOnScrollListener(this);
        //为头布局添加动画效果
        // 下拉时
        mAnimation = new RotateAnimation(0, -180, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        // 设置插入器
        mAnimation.setInterpolator(new LinearInterpolator());
        mAnimation.setDuration(250);
        // 动画停止时停留在最后一个位置
        mAnimation.setFillAfter(true);
        // 松手时
        mReverseAnimation = new RotateAnimation(-180, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        mReverseAnimation.setInterpolator(new LinearInterpolator());
        mReverseAnimation.setDuration(250);
        mReverseAnimation.setFillAfter(true);
        // 动画开始于按下
        mState = DONE;
        mISRefreshable = false;
    }


    /**
     * 由于安卓的运行机制决定了无法再组件类外部使用getWidth和getHeight方法
     * 必须使用View.getMeasuredWidth和View.getMeasureHeight方法获得当前组件的宽度和高度
     * 在调用这两个方法之前，必须调用View.measure方法先测量组件宽度和高度。
     *
     * @param child
     */
    private void measureView(View child) {
        // 布局个数
        android.view.ViewGroup.LayoutParams params = child.getLayoutParams();

        if (params == null) {
            params = new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        }

        // 得到宽
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, params.width);

        //高就是布局的高
        int lpHeight = params.height;

        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.UNSPECIFIED);
        }

        child.measure(childWidthSpec, childHeightSpec);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }


    /**
     * 滚动一直回调,直到停止滚动时才停止回调,单击时回调一次
     * @param view
     * @param firstVisibleItem 当前能看见的第一个列表项(从0开始)
     * @param visibleItemCount 当前能看见的列表项个数(小半个也算)
     * @param totalItemCount 列表项总数
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // 第一个行布局的位置 == 当前能看见的第一个列表项
        mFirstItemIndex = firstVisibleItem;
    }

    //  自定义刷新接口
    public interface OnRefreshListener {
        void onRefresh();
    }

    // 接口中的刷新方法
    private void onRefresh() {
        if (mRefreshListener != null) {
            mRefreshListener.onRefresh();
        }
    }

    //第二次刷新已加载完成的方法
    public void onRefreshComplete() {
        // 刷新完成时候
        mState = DONE;
        mLastUpdatedTextView.setVisibility(GONE);
        //mLastUpdatedTextView.setText("已加载完成：" + new Date().toLocaleString());
        // 改变头布局
        changeHeaderViewByState();
    }

    // 自己定义接口的set方法
    public void setonRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
        // 开始刷新?
        mISRefreshable = true;
    }

    //触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mISRefreshable) {
            switch (ev.getAction()) {
                // 手指按下屏幕的时候回走ACTION_DOWN
                case MotionEvent.ACTION_DOWN:
                    // 第一个行布局的位置为0
                    if (mFirstItemIndex == 0 && !mIsRecored) {
                        //开始刷新
                        mIsRecored = true;
                        //如果满足判断条件的话，就记录下Y轴的坐标
                        mStartY = (int) ev.getY();
                    }
                    break;

                case MotionEvent.ACTION_UP:
                    if (mState != REFRESHING && mState != LOADING) {
                        if (mState == DONE) {

                        }
                        if (mState == PULL_TO_REFRESH) {
                            mState = DONE;
                            changeHeaderViewByState();
                        }
                        if (mState == RELEASE_TO_REFRESH) {
                            mState = REFRESHING;
                            changeHeaderViewByState();
                            onRefresh();
                        }
                    }
                    mIsBack = false;
                    mIsRecored = false;
                    break;
                // 如果手指在屏幕上滑动 会走ACTION_MOVE
                case MotionEvent.ACTION_MOVE:
                    // 定义一个 tempY 来记录Y轴坐标
                    int tempY = (int) ev.getY();
                    // // 第一个行布局的位置为0  没有开始刷新 得到Y轴位置
                    if (!mIsRecored && mFirstItemIndex == 0) {
                        mIsRecored = true;
                        mStartY = tempY;
                    }
                    // 如果
                    if (mState != REFRESHING && mIsRecored && mState != LOADING) {
                        if (mState == RELEASE_TO_REFRESH) {
                            setSelection(0);
                            if ((tempY - mStartY) / RADIO < mHeadContentHeight && (tempY - mStartY) > 0) {
                                mState = PULL_TO_REFRESH;
                                changeHeaderViewByState();
                            } else if (tempY - mStartY <= 0) {
                                mState = DONE;
                                changeHeaderViewByState();
                            }
                        }

                        if (mState == PULL_TO_REFRESH) {
                            setSelection(0);
                            if ((tempY - mStartY) / RADIO >= mHeadContentHeight) {
                                mState = RELEASE_TO_REFRESH;
                                mIsBack = true;
                                changeHeaderViewByState();
                            }
                        } else if (tempY - mStartY <= 0) {
                            mState = DONE;
                            changeHeaderViewByState();
                        }

                        if (mState == DONE) {
                            if (tempY - mStartY > 0) {
                                mState = PULL_TO_REFRESH;
                                changeHeaderViewByState();
                            }
                        }

                        if (mState == PULL_TO_REFRESH) {
                            mHeadView.setPadding(0, -1 * mHeadContentHeight + (tempY - mStartY) / RADIO, 0, 0);
                        }

                        if (mState == RELEASE_TO_REFRESH) {
                            mHeadView.setPadding(0, (tempY - mStartY) / RADIO - mHeadContentHeight, 0, 0);
                        }
                    }
                    break;

                default:
                    break;
            }
        }
        return super.onTouchEvent(ev);
    }

    // 改变头布局的方法
    private void changeHeaderViewByState() {
        switch (mState) {
            // 当开始下拉的时候
            case PULL_TO_REFRESH:
                // 隐藏我的进度条 请释放刷新出现 上次刷新的时间出现 清除动画?
                mProgressBar.setVisibility(GONE);
                mTipsTextView.setVisibility(VISIBLE);
                mLastUpdatedTextView.setVisibility(VISIBLE);
                mArrowImageView.clearAnimation();
                mArrowImageView.setVisibility(VISIBLE);
                // 向上移动没有松手
                if (mIsBack) {
                    mIsBack = false;
                    mArrowImageView.clearAnimation();
                    mArrowImageView.startAnimation(mReverseAnimation);
                    mTipsTextView.setText("下拉刷新");
                } else {
                    mTipsTextView.setText("isBack is false!!!");
                }
                break;

            // (不会) 当按下屏幕的时候
            case DONE:
                mHeadView.setPadding(0, -1 * mHeadContentHeight, 0, 0);
                mProgressBar.setVisibility(GONE);
                mArrowImageView.clearAnimation();
                mArrowImageView.setImageResource(R.mipmap.xlistview_arrow);
                mTipsTextView.setText("已经加载完成");
                mLastUpdatedTextView.setVisibility(VISIBLE);
                break;

            // 刷新中
            case REFRESHING:
                mHeadView.setPadding(0, 0, 0, 0);
                mProgressBar.setVisibility(VISIBLE);
                mArrowImageView.clearAnimation();
                mArrowImageView.setVisibility(GONE);
                mTipsTextView.setText("正在加载中……");
                mLastUpdatedTextView.setVisibility(GONE);
                break;

            // 下拉不松手的时候
            case RELEASE_TO_REFRESH:
                mArrowImageView.setVisibility(VISIBLE);
                mProgressBar.setVisibility(GONE);
                mTipsTextView.setVisibility(VISIBLE);
                mLastUpdatedTextView.setVisibility(VISIBLE);
                mArrowImageView.clearAnimation();
                mArrowImageView.startAnimation(mAnimation);
                mTipsTextView.setText("松开刷新数据");
                break;
            default:
                break;
        }
    }

}
