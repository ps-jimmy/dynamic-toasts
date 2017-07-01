package com.pranavpandey.android.dynamic.toasts.sample;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pranavpandey.android.dynamic.toasts.DynamicToast;
import com.pranavpandey.android.dynamic.utils.DynamicColorUtils;
import com.pranavpandey.android.dynamic.utils.DynamicLinkUtils;
import com.pranavpandey.android.dynamic.utils.DynamicPackageUtils;

public class DynamicToastsActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Enable vector drawable support for this activity. Please consider
     * adding {@code vectorDrawables.useSupportLibrary = true} in the
     * project's {@code build.gradle} file.
     */
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dynamic_toasts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setSubtitle(R.string.app_name_sample);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setColorFilter(DynamicColorUtils.getTintColor(
                ContextCompat.getColor(this, R.color.colorAccent)));

        ((TextView) findViewById(R.id.gradle)).setText(String.format(
                getString(R.string.version_format),
                DynamicPackageUtils.getAppVersion(this)));

        fab.setOnClickListener(this);
        findViewById(R.id.toast_default).setOnClickListener(this);
        findViewById(R.id.toast_default_icon).setOnClickListener(this);
        findViewById(R.id.toast_success).setOnClickListener(this);
        findViewById(R.id.toast_error).setOnClickListener(this);
        findViewById(R.id.toast_success).setOnClickListener(this);
        findViewById(R.id.toast_warning).setOnClickListener(this);
        findViewById(R.id.toast_custom_icon).setOnClickListener(this);
        findViewById(R.id.toast_custom).setOnClickListener(this);
        findViewById(R.id.toast_error_color).setOnClickListener(this);
        findViewById(R.id.toast_success_color).setOnClickListener(this);
        findViewById(R.id.toast_warning_color).setOnClickListener(this);
        findViewById(R.id.toast_default_color).setOnClickListener(this);
        findViewById(R.id.toast_error_icon).setOnClickListener(this);
        findViewById(R.id.toast_success_icon).setOnClickListener(this);
        findViewById(R.id.toast_warning_icon).setOnClickListener(this);
        findViewById(R.id.toast_config_text).setOnClickListener(this);
        findViewById(R.id.toast_config_background).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                DynamicLinkUtils.viewUrl(DynamicToastsActivity.this,
                        "https://github.com/pranavpandey/dynamic-toasts");
                break;

            // Default toast without icon.
            case R.id.toast_default:
                DynamicToast.make(this, getString(R.string.without_icon_desc)).show();
                break;

            // Default toast with icon.
            case R.id.toast_default_icon:
                DynamicToast.make(this, getString(R.string.with_icon_desc),
                        ContextCompat.getDrawable(this, R.drawable.ic_toast_icon)).show();
                break;

            // Error toast.
            case R.id.toast_error:
                DynamicToast.makeError(this, getString(R.string.error_desc)).show();
                break;

            // Success toast.
            case R.id.toast_success:
                DynamicToast.makeSuccess(this, getString(R.string.success_desc)).show();
                break;

            // Warning toast.
            case R.id.toast_warning:
                DynamicToast.makeWarning(this, getString(R.string.warning_desc)).show();
                break;

            // Custom toast without icon.
            case R.id.toast_custom:
                DynamicToast.make(this, getString(R.string.custom_desc),
                        Color.parseColor("#FFFFFF"), Color.parseColor("#000000"),
                        Toast.LENGTH_LONG).show();
                break;

            // Custom toast with icon.
            case R.id.toast_custom_icon:
                DynamicToast.make(this, getString(R.string.custom_desc),
                        ContextCompat.getDrawable(this, R.drawable.ic_social_github),
                        Color.parseColor("#FFFFFF"), Color.parseColor("#000000"),
                        Toast.LENGTH_LONG).show();
                break;

            // Custom error toast.
            case R.id.toast_error_color:
                // Customise toast.
                DynamicToast.Config.getInstance()
                        .setErrorBackgroundColor(Color.parseColor("#673AB7"))
                        .apply();

                DynamicToast.makeError(this, getString(R.string.error_color_desc)).show();

                // Reset customisations.
                DynamicToast.Config.getInstance().reset();
                break;

            // Custom success toast.
            case R.id.toast_success_color:
                // Customise toast.
                DynamicToast.Config.getInstance()
                        .setSuccessBackgroundColor(Color.parseColor("#2196F3"))
                        .apply();

                DynamicToast.makeSuccess(this, getString(R.string.success_color_desc)).show();

                // Reset customisations.
                DynamicToast.Config.getInstance().reset();
                break;

            // Custom warning toast.
            case R.id.toast_warning_color:
                // Customise toast.
                DynamicToast.Config.getInstance()
                        .setWarningBackgroundColor(Color.parseColor("#8BC34A"))
                        .apply();

                DynamicToast.makeWarning(this, getString(R.string.warning_color_desc)).show();

                // Reset customisations.
                DynamicToast.Config.getInstance().reset();
                break;

            // Custom default toast.
            case R.id.toast_default_color:
                // Customise toast.
                DynamicToast.Config.getInstance()
                        .setDefaultBackgroundColor(Color.parseColor("#607d8b"))
                        .setDefaultTintColor(DynamicColorUtils.getTintColor(
                                Color.parseColor("#607d8b")))
                        .apply();

                DynamicToast.make(this, getString(R.string.default_color_desc)).show();

                // Reset customisations.
                DynamicToast.Config.getInstance().reset();
                break;

            // Custom error toast.
            case R.id.toast_error_icon:
                // Customise toast.
                DynamicToast.Config.getInstance()
                        .setErrorIcon(ContextCompat.getDrawable(
                                this, R.drawable.ic_toast_icon))
                        .apply();

                DynamicToast.makeError(this, getString(R.string.error_icon_desc)).show();

                // Reset customisations.
                DynamicToast.Config.getInstance().reset();
                break;

            // Custom success toast.
            case R.id.toast_success_icon:
                // Customise toast.
                DynamicToast.Config.getInstance()
                        .setSuccessIcon(ContextCompat.getDrawable(
                                this, R.drawable.ic_toast_icon))
                        .apply();

                DynamicToast.makeSuccess(this, getString(R.string.success_icon_desc)).show();

                // Reset customisations.
                DynamicToast.Config.getInstance().reset();
                break;

            // Custom warning toast.
            case R.id.toast_warning_icon:
                // Customise toast.
                DynamicToast.Config.getInstance()
                        .setWarningIcon(ContextCompat.getDrawable(
                                this, R.drawable.ic_toast_icon))
                        .apply();

                DynamicToast.makeWarning(this, getString(R.string.warning_icon_desc)).show();

                // Reset customisations.
                DynamicToast.Config.getInstance().reset();
                break;

            // Custom text size and typeface by using DynamicToast.Config class.
            case R.id.toast_config_text:
                // Customise toast.
                DynamicToast.Config.getInstance()
                        .setTextSize(18)
                        .setTextTypeface(Typeface.create(
                                Typeface.SERIF, Typeface.BOLD_ITALIC))
                        .apply();

                DynamicToast.makeError(this, getString(R.string.text_desc)).show();

                // Reset customisations.
                DynamicToast.Config.getInstance().reset();
                break;

            // Custom background by using DynamicToast.Config class.
            case R.id.toast_config_background:
                // Customise toast.
                DynamicToast.Config.getInstance()
                        .setToastBackground(ContextCompat.getDrawable(
                                this, R.drawable.custom_toast_background))
                        .apply();

                DynamicToast.makeSuccess(this, getString(R.string.background_desc)).show();

                // Reset customisations.
                DynamicToast.Config.getInstance().reset();
                break;
        }
    }
}
