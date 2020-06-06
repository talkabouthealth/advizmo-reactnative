// placeReducer.js

import { ADD_PLACE } from '../actions/type';



export const placeReducer = (state = {}, action) => {
  switch(action.type) {
    case ADD_PLACE:
      return  {
          places: action.payload
        }
    default:
      return state;
  }
}

