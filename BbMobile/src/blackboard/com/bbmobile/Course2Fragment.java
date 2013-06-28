package blackboard.com.bbmobile;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Course2Fragment extends Fragment
{
  public static Fragment newInstance( Context context )
  {
    Course1Fragment f = new Course1Fragment();
    return f;
  }

  @Override
  public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
  {
    ViewGroup root = (ViewGroup) inflater.inflate( R.layout.course2_fragment, null );
    return root;
  }
}
