import { createStore, combineReducers,applyMiddleware} from 'redux';
import {placeReducer} from './reducer/reducer';
import thunk from 'redux-thunk';
const rootReducer = combineReducers({
 placeReducer
});

const configureStore = () => {
  return createStore(rootReducer,applyMiddleware(thunk));
}

export default configureStore;