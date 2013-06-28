package blackboard.com.bbmobile;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class Course2Fragment extends ListFragment
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
        
        

    String[] courseActions = getResources().getStringArray( R.array.course_actions );

    List<ParentItem> itemList = new ArrayList<ParentItem>();

    ParentItem parent1 = new ParentItem("Group 1");
    for ( int i = 0; i < 3; i++ )
    {
      parent1.getChildItemList().add( new ChildItem( courseActions[ i ] ) );
    }
    

    ParentItem parent2 = new ParentItem("Group 2");
    for ( int i = 3; i < courseActions.length; i++ )
    {
      parent2.getChildItemList().add( new ChildItem( courseActions[ i ] ) );
    }

    itemList.add( parent1 );
    itemList.add( parent2 );

    /** Creating an array adapter to store the list of countries **/
    ExpandableListViewAdapter adapter = new ExpandableListViewAdapter( inflater.getContext(), itemList );

    ExpandableListView expandableListView  = (ExpandableListView) root.findViewById( R.id.expList );
    /** Setting the list adapter for the ListFragment */
    expandableListView.setAdapter( adapter );

    return root;
  }

  public class ParentItem
  {

    private String title;
    private List<ChildItem> childItemList;

    public ParentItem(String title)
    {
      this.title = title;
      childItemList = new ArrayList<ChildItem>();
    }

    public List<ChildItem> getChildItemList()
    {
      return childItemList;
    }
    
    @Override
    public String toString()
    {
      return this.title;
    }
    
  }

  public class ChildItem
  {
    String item;
    
    public ChildItem(String title)
    {
      this.item = title;
    }
    @Override
    public String toString()
    {
      return item;
    }
  }

 
}
