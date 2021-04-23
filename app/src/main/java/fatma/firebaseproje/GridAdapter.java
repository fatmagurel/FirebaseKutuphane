package fatma.firebaseproje;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fatma.firebaseproje.Model.Kitaplar;

public class GridAdapter extends BaseAdapter {
    ArrayList<Kitaplar>kitaplar;
    LayoutInflater layoutInflater;
    Context context;

    public GridAdapter(Activity activity, ArrayList<Kitaplar> kitaplar){
        this.kitaplar=kitaplar;
        this.context=activity;
        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public GridAdapter() {
        super();
    }

    @Override
    public int getCount() {
        return kitaplar.size();
    }

    @Override
    public Object getItem(int position) {
        return kitaplar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View view=layoutInflater.inflate(R.layout.gridview,null);

        TextView tvAd = (TextView)view.findViewById(R.id.k);

        tvAd.setText(kitaplar.get(position).getAdi());

       return view;
    }
}
