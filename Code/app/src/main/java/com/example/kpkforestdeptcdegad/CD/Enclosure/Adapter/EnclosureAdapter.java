package com.example.kpkforestdeptcdegad.CD.Enclosure.Adapter;

import android.content.Context;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.R;

public class EnclosureAdapter extends RecyclerView.Adapter<EnclosureAdapter.EnclosureVH> {

    Context mContext;

    public EnclosureAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public EnclosureAdapter.EnclosureVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_enclosure,parent,false);
        return new EnclosureVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnclosureAdapter.EnclosureVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class EnclosureVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;
        LinearLayout editBT;

        public EnclosureVH(@NonNull View itemView) {
            super(itemView);

            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL1_expendableTextView);
            editBT = itemView.findViewById(R.id.bt_edit_row_vdc);



            showMoreTV.setOnClickListener(this);
            editBT.setOnClickListener(this);
        }

        public void ShowMore(View view){
            if (expendableLinearLayout2.getVisibility() == view.GONE){
                showMoreTV.setText("Show Less");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(expendingCardView,new AutoTransition());
                    expendableLinearLayout2.setVisibility(View.VISIBLE);
                }
            }else {
                showMoreTV.setText("Read More");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(expendingCardView,new AutoTransition());
                }
                expendableLinearLayout2.setVisibility(View.GONE);
            }
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_rowViewVDC_showMore:
                    ShowMore(v);
                    break;

                case R.id.bt_edit_row_vdc:
                    Toast.makeText(mContext, "Edit", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
