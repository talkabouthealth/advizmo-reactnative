import React, { Component } from 'react';
import { View, Text, TextInput, TouchableHighlight } from 'react-native';
import { connect } from 'react-redux';
import { styles } from './style';
import { ScrollView } from 'react-native-gesture-handler';
import { Button } from 'native-base';

class HowItWorksComponent extends Component {
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
    render() {
        return (
            <ScrollView>
                <View style={styles.headerStyle}>
                    <Text style={styles.headingStyle} >How it works</Text>
                </View>
                <View style={{ padding: 20 }}>
                    <Text style={{ fontSize: 20, fontWeight: "100",padding:5 }}>1.Set a goal for the amount of money you would like to maintain in your checking account.</Text>
                    <Text style={{ fontSize: 20, fontWeight: "100",padding:5}}>2.Connect your accounts.</Text>
                    <Text style={{ fontSize: 20, fontWeight: "100",padding:5 }}>3.We check your accounts everyday to alert you when to move money to higher earning account</Text>
                    <Text style={{ fontSize: 20, fontWeight: "100",padding:5 }}>4.Earn more income automatically</Text>
                </View>
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                        <Button
                            onPress={() => {
                                setTimeout(() => {
                                    this.props.navigation.navigate('OtpScreen')
                                }, 100);
                            }}
                            style={styles.buttonStyle}>
                            <Text style={styles.buttonTextStyle}>Next</Text>
                        </Button>
                       
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

export default connect(mapStateToProps, mapDispatchToProps)(HowItWorksComponent)

