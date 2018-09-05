package com.andrewxa.a11aretrofitloaderssample.loaders.async.cursor;

import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

public class BaseLoader extends CursorLoader {

    private Cursor mCursor;

    public BaseLoader(Context context) {
        super(context);
    }

    @Override
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        Cursor oldCursor = mCursor;
        mCursor = cursor;

        if (isStarted()) {
            super.deliverResult(cursor);
        }

        if (oldCursor != null && oldCursor != cursor && !oldCursor.isClosed()) {
            oldCursor.close();
        }
    }

    @Override
    protected void onStartLoading() {
        if (mCursor != null) {
            deliverResult(mCursor);
        } else {
            forceLoad();
        }
    }

    @Override
    protected void onReset() {
        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        mCursor = null;
    }

}
