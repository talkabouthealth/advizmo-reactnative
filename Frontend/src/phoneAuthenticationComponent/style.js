import { StyleSheet, Dimensions } from 'react-native';
const screenWidth = Math.round(Dimensions.get('window').width);
const screenHeight = Math.round(Dimensions.get('window').height);
export const styles = StyleSheet.create({
    containerStyle: {
        padding: 30
    },
    verificationTextStyle: {
        fontWeight: "600",
        fontSize: 17,
        textAlign: "center"
    },
    subContainerStyle: {
        flexDirection: "column",
        padding: 30
    },
    textStyle: {
        fontWeight: "500",
        fontSize: 15,
        textAlign: "center"
    },
    inboxStyle: {
        height: 40,
        borderRadius: 5,
        width: 250,
        borderColor: "#000",
        borderWidth: 1
    },
    buttonViewStyle: {
        justifyContent: "center",
        alignItems: "center",
        padding: 30
    },
    buttonStyle: {
        width: screenWidth / 1.5, height: screenHeight / 10, padding: 10,
        backgroundColor: '#696969',
        fontWeight: 'bold',
        justifyContent: "center",
        alignItems: "center"
    },
    viewInputStyle: {
        flexDirection: "column",
        padding: 10,
        justifyContent: "center",
        alignItems: "center"
    },
    textInputStyle: {
        fontSize: 18,
        color: "#000",
        textAlign: "center",
        padding: 10
    },
    buttonTextStyle: { color: "#fff" },
    buttonTextStyle2: { color: "#0000CD" }
})