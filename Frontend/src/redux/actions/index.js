import { ADD_PLACE } from './type';
import {Global } from '../../globalVariable';
import { AsyncStorage } from 'react-native';
export const addPlace = placeName => {
  return {
    type: ADD_PLACE,
    payload: placeName
  }
}

export const getAccessToken = (publicToken) => {
  var body= JSON.stringify({
    "client_id": Global.client_id,
    "public_token": publicToken,
    "secret": Global.client_secret
  });
  debugger;
  console.log(body)
 return  (dispatch) =>{
  fetch(Global.apiBaseUrl + "getAccessToken", {
    method: 'POST',
    headers:{'Content-Type':"application/json"},
    body:body
  }).then((response) => {console.log(response);response.json()})
    .then((result) => {
      console.log(result)
     
    })
    .catch((error) => {
      console.log(error);
     
    });
 }
  

}