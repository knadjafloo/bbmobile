package blackboard.com.bbmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter
{
  private Context context;
  private final String[] valuesArray;

  public ImageAdapter( Context context, String[] mobileValues )
  {
    this.context = context;
    this.valuesArray = mobileValues;
  }

  public View getView( int position, View convertView, ViewGroup parent )
  {

    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

    View gridView;

    if ( convertView == null )
    {

      gridView = new View( context );

      // get layout from grid_view_item
      gridView = inflater.inflate( R.layout.grid_view_item, null );

      // set value into textview
      TextView textView = (TextView) gridView.findViewById( R.id.grid_item_label );
      textView.setText( valuesArray[ position ] );

      // set image based on selected text
      TextView textView2 = (TextView) gridView.findViewById( R.id.grid_item_activity );

      long count = Math.round( Math.random() * 10 );
      textView2.setText( count + "" );

    }
    else
    {
      gridView = (View) convertView;
    }

    return gridView;
  }

  @Override
  public int getCount()
  {
    return valuesArray.length;
  }

  @Override
  public Object getItem( int position )
  {
    return null;
  }

  @Override
  public long getItemId( int position )
  {
    return 0;
  }
}
