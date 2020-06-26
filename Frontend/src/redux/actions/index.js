import  * as type from './type';
import {Global } from '../../globalVariable';
import { AsyncStorage } from 'react-native';
export const addPlace = placeName => {
  return {
    type: type.ADD_PLACE,
    payload: placeName
  }
}
export const dasboardScreenData = data => {
  return {
    type: type.DASHBOARD_SCREEN_DATA,
    payload: data
  }
}
export const getAccessToken = (publicToken) => {
  var body= JSON.stringify({
    "client_id": Global.client_id,
    "public_token": publicToken,
    "secret": Global.client_secret
  });
 return  (dispatch) =>{
  fetch(Global.apiBaseUrl + "getAccessToken", {
    method: 'POST',
    headers:{'Content-Type':"application/json"},
    body:body
  }).then((response) => {response.json()})
    .then((result) => {
      console.log(result)
     
    })
    .catch((error) => {
      console.log(error);
     
    });
 }
}
//Dashboard screen data
export const fetchDashboardData = () => {
  const customData = require('./staticData.json');
  return (dispatch)=>{
dispatch(dasboardScreenData(customData))
  }
}