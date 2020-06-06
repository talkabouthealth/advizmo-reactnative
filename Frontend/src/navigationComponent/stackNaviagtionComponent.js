import  React , { Component }from 'react'
import { createStackNavigator } from 'react-navigation-stack';
import {  createAppContainer } from 'react-navigation';
import {Icon } from 'native-base';

import DashboardComponent from '../dashboardComponent/dashboard';
import PlaidComponent from '../plaidComponent/plaidComponent';
import AccountCreateComponent from '../accountCreateComponent/accountCreateComponent';
import StartUpComponent from '../startupScreenComponent/startUpScreenComponent';
import PhoneAuthenticationComponent from '../phoneAuthenticationComponent/phoneAuthenticationComponent';
import HowItWorksComponent from '../howItWorksComponent/howItWorksComponent';
const StackNavigator = createStackNavigator({
  StartUpScreen:{screen :StartUpComponent},
  SignUpScreen:{screen:AccountCreateComponent},
  OtpScreen:{screen:PhoneAuthenticationComponent},
    DashboardScreen: { screen: DashboardComponent },
    PlaidScreen : {screen:PlaidComponent},
    howItWorksScreen:{screen:HowItWorksComponent}
   },
    {
        defaultNavigationOptions: {
            title:"Advizmo",
            headerLeft:()=> null,
            headerStyle: {
              backgroundColor: '#FAFAFA'
                        },
            headerTintColor: '#007bff',
            headerTitleStyle: {
              fontWeight: 'bold',
            },
            headerRight: () =><Icon name="add"  style={{ fontSize: 25, color: '#989898' ,padding:15}} />
           
          },
         
    }
   // HomeScreen: { screen: Home }
  );
const MainStackNavigator = createAppContainer(StackNavigator);



export default MainStackNavigator