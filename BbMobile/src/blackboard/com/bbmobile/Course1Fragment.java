package blackboard.com.bbmobile;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class Course1Fragment extends Fragment
{
  public static Fragment newInstance( Context context )
  {
    Course1Fragment f = new Course1Fragment();
    return f;
  }

  @Override
  public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
  {
    ViewGroup root = (ViewGroup) inflater.inflate( R.layout.course1_fragment, null );

    GridView gridview = (GridView) root.findViewById( R.id.gridview );

    gridview.setAdapter( new ImageAdapter( inflater.getContext(), getResources()
        .getStringArray( R.array.course_actions ) ) );

    gridview.setOnItemClickListener( new OnItemClickListener()
      {
        public void onItemClick( AdapterView<?> parent, View v, int position, long id )
        {
          Toast.makeText( getActivity().getApplicationContext(), "" + position, Toast.LENGTH_SHORT ).show();
        }
      } );
    return root;
  }
}
