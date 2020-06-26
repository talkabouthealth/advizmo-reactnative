import React, { Component } from 'react';
import { View, Text, TouchableHighlight } from 'react-native';
import { connect } from 'react-redux';
import { Button } from 'native-base';
import * as action from '../redux/actions/index';
import { styles } from './style';
class OptionComponent extends Component {
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
                <View style={styles.containerStyle}>
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                        <Button onPress={() => {
                                setTimeout(() => {
                                    this.props.navigation.navigate('DashboardScreen')
                                }, 100);
                            }}
                            style={styles.buttonStyle}>
                            <Text style={styles.buttonTextStyle}>Dashboard</Text>
                        </Button>

                    </View>
                </TouchableHighlight>
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                        <Button
                            onPress={() => {
                                setTimeout(() => {
                                    this.props.navigation.navigate('OtpScreen')
                                }, 100);
                            }}
                            style={styles.buttonStyle}>
                            <Text style={styles.buttonTextStyle}>Suggestions</Text>
                        </Button>

                    </View>
                </TouchableHighlight>
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                        <Button
                            onPress={() => {
                                setTimeout(() => {
                                    this.props.navigation.navigate('OtpScreen')
                                }, 100);
                            }}
                            style={styles.buttonStyle}>
                            <Text style={styles.buttonTextStyle}>Add Account</Text>
                        </Button>

                    </View>
                </TouchableHighlight>
                <TouchableHighlight>
                    <View style={styles.buttonViewStyle}>
                        <Button
                            onPress={() => {
                                setTimeout(() => {
                                    this.props.navigation.navigate('OtpScreen')
                                }, 100);
                            }}
                            style={styles.buttonStyle}>
                            <Text style={styles.buttonTextStyle}>More</Text>
                        </Button>

                    </View>
                </TouchableHighlight>
            </View>
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

export default connect(mapStateToProps, mapDispatchToProps)(OptionComponent)

