import React, { Component } from 'react';
import { View, Text, TouchableHighlight, Dimensions, TextInput } from 'react-native';
import { connect } from 'react-redux';
import * as action from '../redux/actions/index';
import { Button } from 'native-base';
import { styles } from './styles';
import { ScrollView } from 'react-native-gesture-handler';
class AccountCreateComponent extends Component {
    static navigationOptions = ({ navigation, screenProps }) => ({
        header: null

    });
    constructor() {
        super();
        this.state = {

        }
    }
    componentDidMount() {

    }
    render() {
        return (
            <ScrollView style={styles.containerStyle}>
                <View style={styles.headerStyle}>
                    <Text style={styles.headingStyle} >Advizmo</Text>
                    <Text style={styles.subHeadingStyle} >Create your account</Text>
                </View>
                <View style={{ flexDirection: "row", padding: 10, justifyContent: "center", alignItems: "center" }}>
                    <Text style={{ fontSize: 18, color: "#000", textAlign: "center",width:100 }} >Email</Text>
                    <TextInput
                    style={styles.inboxStyle}
                    />

                </View>
                <View style={{ flexDirection: "row", padding: 10, justifyContent: "center", alignItems: "center" }}>
                    <Text style={{ fontSize: 18, color: "#000", textAlign: "center" ,width:100}} >Password</Text>
                    <TextInput
                    style={styles.inboxStyle}
                    />

                </View>
                <View style={{ flexDirection: "row", padding: 10, justifyContent: "center", alignItems: "center" }}>
                    <Text style={{ fontSize: 18, color: "#000", textAlign: "center",width:100 }} >Mobile</Text>
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
                                    this.props.navigation.navigate('OtpScreen')
                                }, 100);
                            }}
                            style={styles.buttonStyle}>
                            <Text style={styles.buttonTextStyle}>Create Account</Text>
                        </Button>
                       
                    </View>
                </TouchableHighlight>
                <View>
                    <Text style={{fontSize:12,padding:10}} >By creating an account you aggree to our <Text style={{fontSize:12,color:"#0000CD"}}>Terms of services</Text> and have read and acknowledge our <Text style={{fontSize:12,color:"#0000CD"}}>Privacy Policy</Text></Text>
                </View> 
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                          <Text style={styles.buttonTextStyle2}>I have an account</Text>
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

export default connect(mapStateToProps, mapDispatchToProps)(AccountCreateComponent)

