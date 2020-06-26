import { StyleSheet,Dimensions } from 'react-native';

const screenWidth = Math.round(Dimensions.get('window').width);
const screenHeight =Math.round( Dimensions.get('window').height);
export const styles = StyleSheet.create({
    containerStyle:{
        height:screenHeight,
        width:screenWidth,
        alignItems: 'center',
        justifyContent: 'center'
      },
      
    buttonStyle:{
        width:screenWidth/1.5,
        height:screenHeight/10,
        padding:10,
        backgroundColor:'#808080', 
        fontWeight: 'bold',
        justifyContent: "center", 
        alignItems: "center"
    },
    buttonViewStyle:{
        justifyContent: "center", 
        alignItems: "center",
        padding:6
      },
      buttonTextStyle:{ color: "#fff" },

  });
  