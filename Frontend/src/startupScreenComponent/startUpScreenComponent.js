import React, { Component } from 'react';
import { View, Text, TouchableHighlight, Dimensions } from 'react-native';
import { connect } from 'react-redux';
import * as action from '../redux/actions/index';
import { Button } from 'native-base';
import { styles } from './styles';
import { ScrollView } from 'react-native-gesture-handler';
const screenWidth = Math.round(Dimensions.get('window').width);
const screenHeight = Math.round(Dimensions.get('window').height);
class StartUpComponent extends Component {
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
                </View>
                <View style={styles.viewStyle}>
                    <Text style={styles.textStyle} >We help you earn for more income</Text>
                </View>
                <View style={styles.viewStyle}>
                    <Text style={styles.textStyle} >Don't miss out on having your money in the highest return accounts.</Text>
                </View>
                <View style={styles.viewStyle}>
                    <Text style={styles.textStyle} >We check your accounts daily to make sure you maximize earning opportunities and minimize fees.</Text>
                </View>
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                        <Button
                            onPress={() => {
                                setTimeout(() => {
                                    this.props.navigation.navigate('SignUpScreen')
                                }, 100);
                            }}
                            style={styles.buttonStyle}>
                            <Text style={styles.buttonTextStyle}>Start Earning</Text>
                        </Button>
                      </View>
                </TouchableHighlight>
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                          <Text style={styles.buttonTextStyle2}>I have an account</Text>
                     </View>
                </TouchableHighlight>
            </ScrollView>
        );

    }s
}

const mapStateToProps = state => {
    return {
    }
}

const mapDispatchToProps = dispatch => {
    return {

    }
}

export default connect(mapStateToProps, mapDispatchToProps)(StartUpComponent)


