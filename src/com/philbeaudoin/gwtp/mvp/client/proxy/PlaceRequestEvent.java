package com.philbeaudoin.gwtp.mvp.client.proxy;

import com.google.gwt.event.shared.GwtEvent;
import com.philbeaudoin.gwtp.mvp.client.EventBus;

/**
 * 
 * This event is fired whenever a  new place is requested, either by 
 * history navigation or directly 
 * 
 * @author David Peterson
 * @author Philippe Beaudoin
 *
 */
public class PlaceRequestEvent extends GwtEvent<PlaceRequestHandler> {

  private static Type<PlaceRequestHandler> TYPE;

  public static Type<PlaceRequestHandler> getType() {
    if ( TYPE == null )
      TYPE = new Type<PlaceRequestHandler>();
    return TYPE;
  }

  private final PlaceRequest request;
  
  /**
   * The handled flag can let others know when the event has been handled.
   * Handlers should call {@link setHandled()} as soon as they figure they
   * are be responsible for this event. Handlers should not process
   * this event if {@link isHandled()} return <code>true</code>. 
   */
  private boolean handled = false;

  public PlaceRequestEvent( PlaceRequest request ) {
    this.request = request;
  }

  @Override
  protected void dispatch( PlaceRequestHandler handler ) {
    handler.onPlaceRequest( this );
  }

  @Override
  public Type<PlaceRequestHandler> getAssociatedType() {
    return getType();
  }

  public PlaceRequest getRequest() {
    return request;
  }

  /**
   * Indicates that the event was handled and that other handlers
   * should not process it.
   */
  public void setHandled() {
    handled = true;
  }

  /**
   * Checks if the event was handled. If it was, then it should not
   * be processed further.
   * 
   * @return <code>true</code> if the event was handled. <code>false</code> otherwise.
   */
  public boolean isHandled() {
    return handled;
  }
  
  /**
   * Fires a {@link PlaceRequestEvent} into the {@link EventBus}, specifying that it
   * does not come from a modification in the History.
   *
   * @param eventBus  The event bus.
   * @param request   The request.
   */
  public static void fire( EventBus eventBus, PlaceRequest request ) {
    eventBus.fireEvent( new PlaceRequestEvent( request ) );
  }
}