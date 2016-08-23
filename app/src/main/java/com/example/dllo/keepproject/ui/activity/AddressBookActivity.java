package com.example.dllo.keepproject.ui.activity;

import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.AddressBookBean;
import com.example.dllo.keepproject.ui.adapter.AddressBookAdapter;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by dllo on 16/8/19.
 * 通讯录
 */
public class AddressBookActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView backImage;
    private ListView addressLv;
    private ArrayList<AddressBookBean> data;
    private AddressBookAdapter addressBookAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_addressbook;
    }

    @Override
    protected void initView() {
        backImage = byView(R.id.address_back);
        addressLv = byView(R.id.address_Lv);


    }

    @Override
    protected void initListeners() {
        backImage.setOnClickListener(this);


    }


    @Override
    protected void initDatas() {

        data = new ArrayList<>();
        cursorPhoneBook();
        addressBookAdapter = new AddressBookAdapter(this);
        addressBookAdapter.setBean(data);
        addressLv.setAdapter(addressBookAdapter);


    }

    /**
     * 电话本获取用户名和头像
     */
    private void cursorPhoneBook() {
        Cursor cursor = getContentResolver().query
                (ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            AddressBookBean bean = new AddressBookBean();
            bean.setUserName(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));

            Long imageId = cursor.getLong(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
            Long phoneId = cursor.getLong(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_ID));
            Bitmap headPhoto = null;
            if (phoneId > 0) {
                Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, imageId);
                InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(), uri);
                headPhoto = BitmapFactory.decodeStream(inputStream);
            } else {
                headPhoto = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            }
            bean.setUserImage(headPhoto);

            data.add(bean);

        }
        cursor.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.address_back:
                goTo(this, AddFriendActivity.class);
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
                break;
        }
    }
}
