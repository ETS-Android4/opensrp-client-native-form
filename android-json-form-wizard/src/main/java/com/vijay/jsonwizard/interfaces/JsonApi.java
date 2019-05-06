package com.vijay.jsonwizard.interfaces;

import android.view.View;

import com.vijay.jsonwizard.customviews.GenericPopupDialog;
import com.vijay.jsonwizard.utils.ValidationStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by vijay on 5/16/15.
 */
public interface JsonApi {
    JSONObject getStep(String stepName);

    void writeValue(String stepName, String key, String value, String openMrsEntityParent,
                    String openMrsEntity, String openMrsEntityId, boolean popup) throws JSONException;

    void writeValue(String stepName, String prentKey, String childObjectKey, String childKey,
                    String value, String openMrsEntityParent, String openMrsEntity,
                    String openMrsEntityId, boolean popup)
            throws JSONException;

    void writeValue(String stepName, String key, String value, String openMrsEntityParent,
                    String openMrsEntity, String openMrsEntityId) throws JSONException;

    void writeValue(String stepName, String parentKey, String childObjectKey, String childKey,
                    String value, String openMrsEntityParent, String openMrsEntity,
                    String openMrsEntityId)
            throws JSONException;

    void writeMetaDataValue(String metaDataKey, Map<String, String> values)
            throws JSONException;

    String currentJsonState();

    String getCount();

    void onFormStart();

    void onFormFinish();

    void clearSkipLogicViews();

    void clearCalculationLogicViews();

    void clearConstrainedViews();

    void clearFormDataViews();

    void addSkipLogicView(View view);

    void addCalculationLogicView(View view);

    void addConstrainedView(View view);

    void refreshHiddenViews(boolean popup);

    void refreshSkipLogic(String parentKey, String childKey, boolean popup);

    void refreshCalculationLogic(String parentKey, String childKey, boolean popup);

    void invokeRefreshLogic(String value, boolean popup, String parentKey, String childKey);

    void addFormDataView(View view);

    ArrayList<View> getFormDataViews();

    JSONObject getObjectUsingAddress(String[] address, boolean popup) throws JSONException;

    JSONObject getObjectUsingAddress(String[] address, boolean popup, JSONObject valueSource) throws JSONException;

    void refreshConstraints(String parentKey, String childKey, boolean popup);

    void addOnActivityResultListener(Integer requestCode, OnActivityResultListener onActivityResultListener);

    void addOnActivityRequestPermissionResultListener(Integer requestCode,
                                                      OnActivityRequestPermissionResultListener onActivityRequestPermissionResultListener);

    void removeOnActivityRequestPermissionResultListener(Integer requestCode);

    void resetFocus();

    JSONObject getmJSONObject();

    void setmJSONObject(JSONObject jsonObject);

    void updateGenericPopupSecondaryValues(JSONArray jsonArray);

    void registerLifecycleListener(LifeCycleListener lifeCycleListener);

    void unregisterLifecycleListener(LifeCycleListener lifeCycleListener);

    void setGenericPopup(GenericPopupDialog context);

    Map<String, ValidationStatus> getInvalidFields();

    String getConfirmCloseMessage();

    void setConfirmCloseMessage(String message);

    String getConfirmCloseTitle();

    void setConfirmCloseTitle(String title);
}
