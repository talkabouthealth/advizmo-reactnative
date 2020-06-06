

import React, { Component } from 'react';
import MainStackNavigator from './src/navigationComponent/stackNaviagtionComponent';
// import Firebase from 'firebase';
// let config = {
//   apiKey: 'AIzaSyDXfDxEnB_K4GXQRbbwPWvS6SpBGiJk7lM',
//   authDomain: 'https://advizmo-457da.firebaseapp.com',
//   databaseURL: 'https://advizmo-457da.firebaseapp.com',
//   projectId: 'advizmo-457da',
//   messagingSenderId: '1079252210026'
// };
export default class App extends Component {
  constructor() {
    super();
  //  let app = Firebase.initializeApp(config);
  }
 render() {

    return (
      <MainStackNavigator />
    );
  }
}



