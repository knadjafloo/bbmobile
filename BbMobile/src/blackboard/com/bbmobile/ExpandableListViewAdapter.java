package blackboard.com.bbmobile;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import blackboard.com.bbmobile.Course2Fragment.ChildItem;
import blackboard.com.bbmobile.Course2Fragment.ParentItem;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter
{

  private static final class ViewHolder
  {
    TextView textLabel;
  }

  private final List<ParentItem> itemList;
  private final LayoutInflater inflater;

  public ExpandableListViewAdapter( Context context, List<ParentItem> itemList )
  {
    this.inflater = LayoutInflater.from( context );
    this.itemList = itemList;
  }

  @Override
  public ChildItem getChild( int groupPosition, int childPosition )
  {

    return itemList.get( groupPosition ).getChildItemList().get( childPosition );
  }

  @Override
  public long getChildId( int groupPosition, int childPosition )
  {
    return childPosition;
  }

  @Override
  public int getChildrenCount( int groupPosition )
  {
    return itemList.get( groupPosition ).getChildItemList().size();
  }

  @Override
  public View getChildView( int groupPosition, int childPosition, boolean isLastChild, View convertView,
                            final ViewGroup parent )
  {
    View resultView = convertView;
    ViewHolder holder;

    if ( resultView == null )
    {

      resultView = inflater.inflate( R.layout.grid_view_item, null ); //TODO change layout id
      holder = new ViewHolder();
      holder.textLabel = (TextView) resultView.findViewById( R.id.grid_item_label ); //TODO change view id
      resultView.setTag( holder );
    }
    else
    {
      holder = (ViewHolder) resultView.getTag();
    }

    final ChildItem item = getChild( groupPosition, childPosition );

    holder.textLabel.setText( item.toString() );

    return resultView;
  }

  @Override
  public ParentItem getGroup( int groupPosition )
  {
    return itemList.get( groupPosition );
  }

  @Override
  public int getGroupCount()
  {
    return itemList.size();
  }

  @Override
  public long getGroupId( final int groupPosition )
  {
    return groupPosition;
  }

  @Override
  public View getGroupView( int groupPosition, boolean isExpanded, View theConvertView, ViewGroup parent )
  {
    View resultView = theConvertView;
    ViewHolder holder;

    if ( resultView == null )
    {
      resultView = inflater.inflate( R.layout.grid_view_item, null ); //TODO change layout id
      resultView.setBackgroundResource( android.R.color.darker_gray );
      holder = new ViewHolder();
      holder.textLabel = (TextView) resultView.findViewById( R.id.grid_item_label ); //TODO change view id
      
      resultView.setTag( holder );
    }
    else
    {
      holder = (ViewHolder) resultView.getTag();
    }

    final ParentItem item = getGroup( groupPosition );

    holder.textLabel.setText( item.toString() );

    return resultView;
  }

  @Override
  public boolean hasStableIds()
  {
    return true;
  }

  @Override
  public boolean isChildSelectable( int groupPosition, int childPosition )
  {
    return true;
  }

}
