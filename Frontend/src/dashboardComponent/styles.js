import { StyleSheet,Dimensions } from 'react-native';

const screenWidth = Math.round(Dimensions.get('window').width);
const screenHeight =Math.round( Dimensions.get('window').height);
export const styles = StyleSheet.create({
  touchEffect:{
    alignItems: "center",
    padding: 10
  },
    container: {
      backgroundColor: "#FAFAFA",
      height: screenHeight,
      width: screenWidth,
      flex: 1
    },
    cardItemSyle: {
      justifyContent: 'space-between',
      flexDirection: "row",
      borderColor: "red",
      borderWidth: 1,
      margin: 5,
      borderColor: '#848484',
      height: 50
    },
    subHeading: {
      color: "#3a3f47",
      fontSize: 18,
      fontWeight: "700"
    },
    imageContent: { resizeMode: "contain", height: 25, width: 25 },
    cardItemText: { color:"#3a3b3e",fontWeight: "700", fontSize: 13 },
    cardItemAmount: { fontWeight: "700", fontSize: 13, color: "#2ca01c" },
    cardItemHeadings: { fontWeight: "700", fontSize: 18, color: "#2ca01c" },
    cardItemAmount_RedColor:{ fontWeight: "700", fontSize: 13, color: "red" },
    cardItemHeading_RedColor:{ fontWeight: "700", fontSize: 18, color: "red" },

    paddingView: { padding: 2 },
    cardItemCreditCard:{fontWeight: "700", fontSize: 13, color: "#000" },
    upcomingBillsCardItem:{
      justifyContent: 'flex-start',
      flexDirection: "row",
      borderColor: "red",
      borderWidth: 1,
      margin: 5,
      borderColor: '#848484',
      height: 50
  },
  dateView:{flexDirection:"column",paddingRight:10},
  greyColorText:{color:"#989898",fontSize:10},
  upcomingBillAmountView:{padding:10,right:0,position:'absolute'},
  blueColorText:{color:"#007bff",fontWeight:"700",fontSize:10},
  transactionTitle:{fontWeight:"700",color:"#848484"}
  });
  