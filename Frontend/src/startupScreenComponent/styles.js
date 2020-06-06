import { StyleSheet,Dimensions } from 'react-native';

const screenWidth = Math.round(Dimensions.get('window').width);
const screenHeight =Math.round( Dimensions.get('window').height);
export const styles = StyleSheet.create({
  textStyle:{
    fontSize: 25, 
    fontFamily: 'Open Sans', 
    color: "#565656" 
  },
  viewStyle:{ padding: 10 },
  headingStyle:{ 
    fontSize: 34, 
    fontFamily: 'Open Sans', 
    fontWeight: "500", 
    color: "#007bff" 
  },
  containerStyle:{
    height:screenHeight,
    width:screenWidth
  },
  buttonStyle:{
    width:screenWidth/1.5,height:screenHeight/10,padding:10,
    backgroundColor:'#808080', 
    fontWeight: 'bold',
    justifyContent: "center", 
    alignItems: "center"
},
buttonStyle2:{
  margin:10,
  width:screenWidth/1.5,height:screenHeight/10,padding:10,
  backgroundColor:'#C0C0C0', 
  fontWeight: 'bold',
  justifyContent: "center", 
  alignItems: "center"
},
  headerStyle:{ 
    padding: 10, 
    justifyContent: "center", 
    alignItems: "center" 
  },
  buttonTextStyle:{ color: "#fff" },

    buttonTextStyle2:{ color: "#0000CD" },
    buttonViewStyle:{
      justifyContent: "center", 
      alignItems: "center",
      padding:6
    }
  
  });
  