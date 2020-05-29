import React, { Component } from 'react';
import { View, Text, TextInput, TouchableHighlight } from 'react-native';
import { connect } from 'react-redux';
import { styles } from './style';
import { ScrollView } from 'react-native-gesture-handler';
import { Button } from 'native-base';

class PhoneAuthenticationComponent extends Component {
    static navigationOptions = ({ navigation, screenProps }) => ({
        header: null
    });
    constructor() {
        super();
        this.state = {
            phone: '',
            confirmResult: null,
            verificationCode: '',
            userId: ''
        }
    }
    componentDidMount() {

    }
    validatePhoneNumber = () => {
        var regexp = /^\+[0-9]?()[0-9](\s|\S)(\d[0-9]{8,16})$/
        return regexp.test(this.state.phone)
    }


    render() {
        return (
            <ScrollView>
                <View style={styles.containerStyle}>
                    <Text style={styles.verificationTextStyle}> Enter Verification Code</Text>
                </View>
                <View style={styles.subContainerStyle}>
                    <Text style={styles.textStyle}> We sent a code to :</Text>
                    <Text style={styles.textStyle}> (917)710-1927</Text>
                </View>
                <View style={styles.viewInputStyle}>
                    <Text style={styles.textInputStyle} >Enter the 6 digit code</Text>
                    <TextInput
                        keyboardType="phone-pad"
                        style={styles.inboxStyle}
                    />

                </View>
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                        <Button
                            onPress={() => {
                                setTimeout(() => {
                                    this.props.navigation.navigate('howItWorksScreen')
                                }, 100);
                            }}
                            style={styles.buttonStyle}>
                            <Text style={styles.buttonTextStyle}>Next Screen</Text>
                        </Button>

                    </View>
                </TouchableHighlight>
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                        <Text style={styles.buttonTextStyle2}>Resend Code</Text>
                    </View>
                </TouchableHighlight>

            </ScrollView>
        );

    }
}

const mapStateToProps = state => {
    return {
    }
}

const mapDispatchToProps = dispatch => {
    return {

    }
}

export default connect(mapStateToProps, mapDispatchToProps)(PhoneAuthenticationComponent)

