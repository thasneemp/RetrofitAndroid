package pro.muhammed.com.retrofitandroid.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.muhammed.com.retrofitandroid.R;
import pro.muhammed.com.retrofitandroid.models.Contact;

/**
 * Created by muhammed on 7/11/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {
    private List<Contact> contacts;
    private Context context;

    public ContactAdapter(Context context, List<Contact> contacts) {

        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contacts_row, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        holder.mNameTextView.setText(contacts.get(position).getName());
        holder.mPhoneTextView.setText(contacts.get(position).getPhone().getMobile());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public static class ContactHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nameTextView)
        TextView mNameTextView;

        @BindView(R.id.phoneTextView)
        TextView mPhoneTextView;

        public ContactHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
