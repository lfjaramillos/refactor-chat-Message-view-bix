package jp.bassaer.chatmessageview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nakayama on 2016/08/08.
 */
public class MessageAdapter extends ArrayAdapter<Message> {

    private LayoutInflater mLayoutInflater;

    public MessageAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        Message message = getItem(position);

        if (!message.isDateCell()) {
            if (convertView == null) {
                if (message.isRightMessage()) {
                    convertView = mLayoutInflater.inflate(R.layout.message_view_right, null);
                } else {
                    convertView = mLayoutInflater.inflate(R.layout.message_view_left, null);
                }
                holder = new ViewHolder();
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }



            if (message.isRightMessage()) {
                holder.icon = (ImageView)convertView.findViewById(R.id.right_user_icon);
                holder.messageText = (TextView)convertView.findViewById(R.id.right_message_text);
                holder.timeText = (TextView)convertView.findViewById(R.id.right_time_display_text);
            } else {
                holder.icon = (ImageView)convertView.findViewById(R.id.left_user_icon);
                holder.messageText = (TextView)convertView.findViewById(R.id.left_message_text);
                holder.timeText = (TextView)convertView.findViewById(R.id.left_time_display_text);
            }

            holder.icon.setImageBitmap(message.getUserIcon());
            holder.messageText.setText(message.getMessageText());
            holder.timeText.setText(message.getTimeText());
        } else {
            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.date_cell, null);
                holder = new ViewHolder();
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.dateSeparatorText = (TextView)convertView.findViewById(R.id.date_separate_text);
            holder.dateSeparatorText.setText(message.getDateSeparateText());
        }

        return convertView;
    }

    @Override
    public boolean isEnabled(int position){
        return false;
    }

    class ViewHolder {
        ImageView icon;
        TextView messageText;
        TextView timeText;
        TextView dateSeparatorText;
    }
}
