package blackboard.com.bbmobile;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity
{

  public static final String ARG_COURSE_ID = "course_id";

  private String[] courseTitles;
  private ListView mDrawerList;
  private DrawerLayout mDrawerLayout;
  private CharSequence mTitle;
  private CharSequence mDrawerTitle;

  @Override
  protected void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_main );

    mTitle = mDrawerTitle = getTitle();
    mDrawerLayout = (DrawerLayout) findViewById( R.id.drawer_layout );
    mDrawerList = (ListView) findViewById( R.id.left_drawer );

    // set a custom shadow that overlays the main content when the drawer opens
    //    mDrawerLayout.setDrawerShadow( R.drawable.drawer_shadow, GravityCompat.START );

        courseTitles = getResources().getStringArray( R.array.courses_names );

    NsMenuAdapter mAdapter = new NsMenuAdapter( this );

    // Add Header
    mAdapter.addHeader( R.string.course_header );

    mAdapter.add( new NsMenuItemModel( R.string.course1, R.drawable.course_icon, false, 5 ) );
    mAdapter.add( new NsMenuItemModel( R.string.course2, R.drawable.course_icon ) );
    mAdapter.add( new NsMenuItemModel( R.string.course3, R.drawable.course_icon, false, 9 ) );
    mAdapter.add( new NsMenuItemModel( R.string.course4, R.drawable.course_icon ) );

    //add Header
    mAdapter.addHeader( R.string.org_header );
    mAdapter.add( new NsMenuItemModel( R.string.org1, R.drawable.ic_menu_allfriends ) );

    // Set the adapter for the list view
    mDrawerList.setAdapter( mAdapter );
    // Set the list's click listener
    mDrawerList.setOnItemClickListener( new DrawerItemClickListener() );
  }

  @Override
  public boolean onCreateOptionsMenu( Menu menu )
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate( R.menu.main, menu );
    return true;
  }

  private class DrawerItemClickListener implements ListView.OnItemClickListener
  {
    @Override
    public void onItemClick( AdapterView parent, View view, int position, long id )
    {
      selectItem( position );
    }
  }

  /** Swaps fragments in the main content view */
  private void selectItem( int position )
  {
    Fragment fragment = null;

    switch ( position )
    {
      case 1:
        fragment = new Course1Fragment();
        break;
      case 2:
        fragment = new Course2Fragment();
        break;
      case 3:
        fragment = new Course3Fragment();
        break;
      default:
        fragment = new Course1Fragment();
        break;
    }
    
    if ( position > 3 )
      position = 1;
    // Create a new fragment and specify the planet to show based on position
    Bundle args = new Bundle();
    args.putInt( ARG_COURSE_ID, position );
    fragment.setArguments( args );

    // Insert the fragment by replacing any existing fragment
    android.app.FragmentManager fragmentManager = getFragmentManager();
    fragmentManager.beginTransaction().replace( R.id.content_frame, fragment ).commit();

    // update selected item and title, then close the drawer
    mDrawerList.setItemChecked( position, true );
    setTitle( courseTitles[ position ] );
    mDrawerLayout.closeDrawer( mDrawerList );
  }

  @Override
  public void setTitle( CharSequence title )
  {
    mTitle = title;
    getActionBar().setTitle( mTitle );  //set the title after we click on an item in drawer
  }
}
