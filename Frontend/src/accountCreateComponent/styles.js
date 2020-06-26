import { StyleSheet, Dimensions } from 'react-native';

const screenWidth = Math.round(Dimensions.get('window').width);
const screenHeight = Math.round(Dimensions.get('window').height);
export const styles = StyleSheet.create({
    containerStyle: {
        height: screenHeight,
        width: screenWidth
    }, viewStyle: { padding: 10 },
    headingStyle: {
        fontSize: 34,
        fontFamily: 'Open Sans',
        fontWeight: "500",
        color: "#007bff"
    },
    headerStyle: {
        padding: 10,
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
    inboxStyle: {
        margin: 10,
        height: 40,
        borderRadius: 5,
        width: 250,
        borderColor: "#000",
        borderWidth: 1
    },
    buttonStyle: {
        width: screenWidth / 1.5, height: screenHeight / 10, padding: 10,
        backgroundColor: '#696969',
        fontWeight: 'bold',
        justifyContent: "center",
        alignItems: "center"
    },
    buttonViewStyle: {
        justifyContent: "center",
        alignItems: "center",
        padding: 6,
        backgroundColor: '#696969',

    },
    buttonTextStyle: { color: "#fff" },
    buttonTextStyle2:{ color: "#0000CD" }

});
