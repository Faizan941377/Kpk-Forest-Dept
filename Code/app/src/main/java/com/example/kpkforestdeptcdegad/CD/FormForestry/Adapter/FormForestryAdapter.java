package com.example.kpkforestdeptcdegad.CD.FormForestry.Adapter;

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
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.R;

public class FormForestryAdapter extends RecyclerView.Adapter<FormForestryAdapter.FormForestryVH> {

    Context mContext;

    public FormForestryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FormForestryAdapter.FormForestryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_form_forestry,parent,false);
        return new FormForestryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormForestryAdapter.FormForestryVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class FormForestryVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;
        LinearLayout editBT;

        public FormForestryVH(@NonNull View itemView) {
            super(itemView);

            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL2_expendableTextView);
            editBT = itemView.findViewById(R.id.bt_edit_row_vdc);



            showMoreTV.setOnClickListener(this);
            editBT.setOnClickListener(this);

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
    }
}
