package com.framgia.toandoan;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.framgia.toandoan.databinding.ActivityMainBinding;

import java.io.File;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity implements OptionAdapter.OnAdapterClick {
    private static final int READ_EXTERNAL_REQUEST = 1;
    private static final int PICK_IMAGE_REQUEST = 2;
    private RecyclerView mRecyclerView;
    private OptionAdapter mAdapter;
    private ActivityMainBinding mBinding;
    private OptionItem mOptionItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mAdapter = new OptionAdapter(this);
        mRecyclerView = mBinding.recyclerOption;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAddImage(OptionItem item) {
        mOptionItem = item;
        requestPermionAndPickImage();
    }

    private void requestPermionAndPickImage() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            pickImage();
            return;
        }
        int result = ContextCompat.checkSelfPermission(this,
            READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            pickImage();
        } else {
            requestPermissions(new String[]{
                READ_EXTERNAL_STORAGE}, READ_EXTERNAL_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults) {
        if (requestCode != READ_EXTERNAL_REQUEST) return;
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            pickImage();
        } else {
            Toast.makeText(getApplicationContext(), R.string.permission_denied,
                Toast.LENGTH_LONG).show();
        }
    }

    public void pickImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"),
            PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null &&
            data.getData() != null) {
            Uri selectedImageURI = data.getData();
            String url = getRealPathFromURI(selectedImageURI);
            mOptionItem.setUrl(url);
        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }
}
