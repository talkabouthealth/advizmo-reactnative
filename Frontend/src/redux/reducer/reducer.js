// placeReducer.js

import * as type from '../actions/type';



export const placeReducer = (state = {}, action) => {
  switch(action.type) {
    case type.ADD_PLACE:
      return  {
          places: action.payload
        }
        case type.DASHBOARD_SCREEN_DATA:
          return  {
              dashboardScreenData: action.payload
            }
    default:
      return state;
  }
}

