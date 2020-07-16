package lk.nibm.swiftsalon.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import cn.pedant.SweetAlert.SweetAlertDialog;
import lk.nibm.swiftsalon.R;

public class CustomDialog extends Dialog {

    private WeakReference<Context> context;
    private SweetAlertDialog alert;

    public CustomDialog(Context context) {
        super(context);
        this.context = new WeakReference<>(context);
    }

    public void showAlert(String message) {
        alert = new SweetAlertDialog(context.get(), SweetAlertDialog.NORMAL_TYPE);
        alert.setContentText(message);
        alert.show();

        Button btnConfirm = alert.findViewById(R.id.confirm_button);
        btnConfirm.setBackgroundResource(R.drawable.button_shape);
    }

    public void showToast(String message) {
        View layout = getLayoutInflater().inflate(R.layout.toast_custom, findViewById(R.id.layout_toast_custom));

        TextView txtToast = layout.findViewById(R.id.txt_custom_toast);
        txtToast.setText(message);

        Toast toast = new Toast(context.get());
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
