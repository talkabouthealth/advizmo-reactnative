import { StyleSheet, Dimensions } from 'react-native';

const screenWidth = Math.round(Dimensions.get('window').width);
const screenHeight = Math.round(Dimensions.get('window').height);
export const styles = StyleSheet.create({
    headingStyle: {
        fontSize: 34,
        fontFamily: 'Open Sans',
        fontWeight: "500",
        color: "#000"
    },
    headerStyle: {
        padding: 30,
        justifyContent: "center",
        alignItems: "center"
    },
    subHeadingStyle: {
        padding: 15,
        fontSize: 14,
        fontFamily: 'Open Sans',
        fontWeight: "500",
        color: "#000"
    },
    buttonViewStyle: {
        justifyContent: "center",
        alignItems: "center",
        padding: 6
    },
    buttonStyle: {
        width: screenWidth / 1.5, height: screenHeight / 10, padding: 10,
        backgroundColor: '#696969',
        fontWeight: 'bold',
        justifyContent: "center",
        alignItems: "center"
    },
    buttonTextStyle: { color: "#fff" }
})