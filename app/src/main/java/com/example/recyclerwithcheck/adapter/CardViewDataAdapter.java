package com.example.recyclerwithcheck.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerwithcheck.R;
import com.example.recyclerwithcheck.models.Student;

import java.util.List;

public class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {

	private List<Student> stList;

	public CardViewDataAdapter(List<Student> students) {
		this.stList = students;

	}

	// Create new views
	@Override
	public CardViewDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
															 int viewType) {
		// create a new view
		View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.cardview_row, null);

		// create ViewHolder

		ViewHolder viewHolder = new ViewHolder(itemLayoutView);

		return viewHolder;
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {

		final int pos = position;

		viewHolder.tvName.setText(stList.get(position).getName());

		viewHolder.tvEmailId.setText(stList.get(position).getEmailId());

		viewHolder.chkSelected.setChecked(stList.get(position).isSelected());

		viewHolder.chkSelected.setTag(stList.get(position));

		
		viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				CheckBox cb = (CheckBox) v;
				Student contact = (Student) cb.getTag();

				contact.setSelected(cb.isChecked());
				stList.get(pos).setSelected(cb.isChecked());


			}
		});

	}

	// Return the size arraylist
	@Override
	public int getItemCount() {
		return stList.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		public TextView tvName;
		public TextView tvEmailId;

		public CheckBox chkSelected;

		public Student singlestudent;

		public ViewHolder(View itemLayoutView) {
			super(itemLayoutView);

			tvName = (TextView) itemLayoutView.findViewById(R.id.tvName);

			tvEmailId = (TextView) itemLayoutView.findViewById(R.id.tvEmailId);
			chkSelected = (CheckBox) itemLayoutView
					.findViewById(R.id.chkSelected);

		}

	}

	// method to access in activity after updating selection
	public List<Student> getStudentist() {
		return stList;
	}

}
