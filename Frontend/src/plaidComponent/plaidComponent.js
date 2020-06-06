import React, { Component } from 'react';
import { View, Text, AsyncStorage } from 'react-native';
import PlaidAuthenticator from 'react-native-plaid-link';
import { connect } from 'react-redux';
import * as action from '../redux/actions/index';
class PlaidComponent extends Component {
    constructor() {
        super();
        this.state = {
            publicToken: ''
        }
    }
  
    onMessage = (data) => {
        if (data.action === 'plaid_link-undefined::connected') {
            this.setState({
                publicToken: data.metadata.public_token
            })
            this.props.getAccessToken(data.metadata.public_token)
        }
    }
    render() {
        return (
            this.state.publicToken === '' ?
                <PlaidAuthenticator
                    onMessage={(data) => this.onMessage(data)}
                    publicKey="e145e84b11389031af8d719506f131"
                    env="sandbox"
                    product="auth"
                    clientName="Karan Kumar"
                    selectAccount={false}
                />
                :
                <View style={{ height: 900, width: 200, paddingTop: 80 }}>
                    <Text style={{ fontWeight: "700", fontSize: 18, justifyContent: "space-between", alignSelf: "center" }}>
                        {this.state.publicToken}
                    </Text>
                </View>
        );
    }
}


const mapStateToProps = state => {
    return {
      places: state.placeReducer.places
    }
  }
  
  const mapDispatchToProps = dispatch => {
    return {
      add: (name) => {
        dispatch(addPlace(name))
      },
      getAccessToken : (publicToken)=>{
        dispatch(action.getAccessToken(publicToken))
      }
    }
  }
  
  export default connect(mapStateToProps, mapDispatchToProps)(PlaidComponent)
  

