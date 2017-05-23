package childfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.hulonghua.one.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hulonghua on 2017/5/3.
 */
public class Allfragment extends Fragment {
    @Bind(R.id.listview)
    ListView listview;
    private Context context;

    public Allfragment() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_layout, container, false);
        ButterKnife.bind(this, view);
        context = getActivity();
        SimpleAdapter adapter = new SimpleAdapter(context, getdata(), R.layout.alllist_layout,
                new String[]{"listnumber", "listtime", "place", "name", "number", "spname", "shuliang", "jiage", "youhui", "shifu"},
                new int[]{R.id.listnumber, R.id.listtime, R.id.place, R.id.name, R.id.number, R.id.spname, R.id.shuliang,
                        R.id.jiage, R.id.youhui, R.id.shifu});
        listview.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    private List<Map<String,Object>> getdata(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listnumber","订单编号：201705230001");
        map.put("listtime","下单时间：5月23日 13：08");
        map.put("place","地址：xxxxx");
        map.put("name","xxxxxx：");
        map.put("number","17858956347");
        map.put("spname","xxxxxx");
        map.put("shuliang","*1");
        map.put("jiage","13");
        map.put("youhui","-4");
        map.put("shifu","9");
        list.add(map);
        return list;
    }
}
