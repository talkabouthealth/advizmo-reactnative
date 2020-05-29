import React, { Component } from 'react';
import { View, Text, Image, ScrollView, TouchableHighlight } from 'react-native';
import { Card, CardItem, Button, Content, Left, Body, Icon, Right } from 'native-base';
import { styles } from './styles';
import { connect } from 'react-redux';
import * as action from '../redux/actions/index';

class DashboardComponent extends Component {
   
    constructor() {
        super();
        this.state = {

        }
    }
    componentDidMount(){
       // this.props.add("MEhak")
      
    }
    render() {
        return (

            <ScrollView>
                {/* Content Section */}
                <Card>
                    <CardItem header>
                        <Left>
                            <Text style={styles.subHeading}>Accounts</Text>
                        </Left>
                        <Body></Body>
                        <Right>
                            <Icon name="angle-right" style={{ fontSize: 20, color: '#007bff' }} type="FontAwesome" />
                        </Right>
                    </CardItem>

                    <CardItem style={styles.cardItemSyle}>
                        <View style={styles.paddingView}>
                            <Image source={require('../../assets/dollar-icon.jpg')} style={styles.imageContent} />
                        </View>
                        <View style={styles.paddingView}><Text style={styles.cardItemText}>Net Worth</Text></View>
                        <View style={styles.paddingView}><Text style={styles.cardItemAmount}>$1780.74</Text></View>
                    </CardItem>

                    <CardItem style={styles.cardItemSyle}>
                        <View style={styles.paddingView}>
                            <Image source={require('../../assets/saving-icon.jpg')} style={styles.imageContent} />
                        </View>
                        <View style={styles.paddingView}><Text style={styles.cardItemText}>Checking</Text></View>
                        <View style={styles.paddingView}><Text style={styles.cardItemAmount}>$1780.74</Text></View>
                    </CardItem>


                    <CardItem style={styles.cardItemSyle}>
                        <View style={styles.paddingView}>
                            <Image source={require('../../assets/saving-icon.jpg')} style={styles.imageContent} />
                        </View>
                        <View style={styles.paddingView}><Text style={styles.cardItemText}>Savings</Text></View>
                        <View style={styles.paddingView}><Text style={styles.cardItemAmount}>$1780.74</Text></View>
                    </CardItem>

                    <CardItem style={styles.cardItemSyle}>
                        <View style={styles.paddingView}>
                            <Image source={require('../../assets/credit-icon.jpg')} style={styles.imageContent} />
                        </View>
                        <View style={styles.paddingView}><Text style={styles.cardItemText}>Credit Card</Text></View>
                        <View style={styles.paddingView}><Text style={styles.cardItemCreditCard}>$1780.74</Text></View>
                    </CardItem>

                    <CardItem style={styles.cardItemSyle}>
                        <View style={styles.paddingView}>
                            <Image source={require('../../assets/graph-icon.jpg')} style={styles.imageContent} />
                        </View>
                        <View style={styles.paddingView}><Text style={styles.cardItemText}>Investment</Text></View>
                        <View style={styles.paddingView}><Text style={styles.cardItemAmount}>$1780.74</Text></View>
                    </CardItem>
                    <CardItem style={styles.cardItemSyle}>
                        <View style={styles.paddingView}>
                            <Image source={require('../../assets/graph-icon.jpg')} style={styles.imageContent} />
                        </View>
                        <View style={styles.paddingView}><Text style={styles.cardItemText}>Loan</Text></View>
                        <View style={styles.paddingView}><Text style={styles.cardItemCreditCard}>$1780.74</Text></View>
                    </CardItem>
                </Card>

                <Card>
                    <CardItem header>
                        <Left>
                            <Text style={styles.subHeading}>Upcoming Bills </Text>
                        </Left>
                        <Body></Body>
                        <Right>
                            <Icon name="angle-right" style={{ fontSize: 20, color: '#007bff' }} type="FontAwesome" />
                        </Right>
                    </CardItem>
                    <CardItem style={styles.upcomingBillsCardItem}>
                        <View style={styles.dateView}>
                            <Text style={styles.greyColorText}> Jan </Text>
                            <Text style={styles.greyColorText}> 27 </Text>
                        </View>
                        <View style={styles.paddingView}>
                            <Text style={styles.cardItemText}>Blue Cash Every..</Text>
                            <Text style={styles.greyColorText}> Past Due </Text>
                        </View>
                        <View style={styles.upcomingBillAmountView}><Text style={styles.cardItemCreditCard}>$175.73</Text>
                            <Text style={styles.blueColorText}> Mark as paid </Text>
                        </View>
                    </CardItem>
                    <CardItem style={styles.upcomingBillsCardItem}>
                        <View style={styles.dateView}>
                            <Text style={styles.greyColorText}> Mar </Text>
                            <Text style={styles.greyColorText}> 27 </Text>
                        </View>
                        <View style={styles.paddingView}>
                            <Text style={styles.cardItemText}>CREDIT CARD</Text>
                            <Text style={styles.greyColorText}>AutoPay </Text>
                        </View>
                        <View style={styles.upcomingBillAmountView}><Text style={styles.cardItemCreditCard}>$1041.73</Text>
                            <Text style={styles.blueColorText}> Mark as paid </Text>
                        </View>
                    </CardItem>
                    <CardItem style={styles.upcomingBillsCardItem}>
                        <View style={styles.dateView}>
                            <Text style={styles.greyColorText}> Apr </Text>
                            <Text style={styles.greyColorText}> 22 </Text>
                        </View>
                        <View style={styles.paddingView}>
                            <Text style={styles.cardItemText}>CREDIT CARD</Text>
                            <Text style={styles.greyColorText}>AutoPay </Text>
                        </View>
                        <View style={styles.upcomingBillAmountView}><Text style={styles.cardItemCreditCard}>$1063.73</Text>
                            <Text style={styles.blueColorText}> Mark as paid </Text>
                        </View>
                    </CardItem>
                </Card>
                <Card>
                    <CardItem header>
                        <Left>
                            <Text style={styles.subHeading}>Transactions</Text>
                        </Left>
                        <Body></Body>
                        <Right>
                            <Icon name="angle-right" style={{ fontSize: 20, color: '#007bff' }} type="FontAwesome" />
                        </Right>
                    </CardItem>
                    <CardItem style={styles.upcomingBillsCardItem}>
                        <View style={styles.dateView}>
                            <Text style={styles.transactionTitle}>FID BKGSVC LLC CO EN.. </Text>
                            <Text style={styles.greyColorText}> Buy </Text>
                        </View>
                        <View style={styles.upcomingBillAmountView}><Text style={styles.cardItemCreditCard}>-$1703.00</Text>
                            <Text style={styles.greyColorText}>Mar 05,2020 </Text>
                        </View>
                    </CardItem>
                    <CardItem style={styles.upcomingBillsCardItem}>
                        <View style={styles.dateView}>
                            <Text style={styles.transactionTitle}>Dollar Tree </Text>
                            <Text style={styles.greyColorText}> Shopping </Text>
                        </View>
                        <View style={styles.upcomingBillAmountView}><Text style={styles.cardItemCreditCard}>-$774.00</Text>
                            <Text style={styles.greyColorText}>Mar 05,2020 </Text>
                        </View>
                    </CardItem>
                    <CardItem style={styles.upcomingBillsCardItem}>
                        <View style={styles.dateView}>
                            <Text style={styles.transactionTitle}>WESTFORD HARDWARE </Text>
                            <Text style={styles.greyColorText}> Buy </Text>
                        </View>
                        <View style={styles.upcomingBillAmountView}><Text style={styles.cardItemCreditCard}>-$10.14</Text>
                            <Text style={styles.greyColorText}>Mar 05,2020 </Text>
                        </View>
                    </CardItem>
                    <CardItem style={styles.upcomingBillsCardItem}>
                        <View style={styles.dateView}>
                            <Text style={styles.transactionTitle}>APPLE</Text>
                            <Text style={styles.greyColorText}> Electronics & software </Text>
                        </View>
                        <View style={styles.upcomingBillAmountView}><Text style={styles.cardItemCreditCard}>-$1097.14</Text>
                            <Text style={styles.greyColorText}>Mar 04,2020 </Text>
                        </View>
                    </CardItem>
                    <CardItem style={styles.upcomingBillsCardItem}>
                        <View style={styles.dateView}>
                            <Text style={styles.cardItemText}>ACADEMY EXPRESS</Text>
                            <Text style={styles.greyColorText}> Travel </Text>
                        </View>
                        <View style={styles.upcomingBillAmountView}><Text style={styles.cardItemCreditCard}>-$15.56</Text>
                            <Text style={styles.greyColorText}>Mar 04,2020 </Text>
                        </View>
                    </CardItem>
                </Card>
                <Card>
                <TouchableHighlight style={styles.button}>
                        <CardItem style={{ justifyContent: "center" }} >
                            <Button
                                onPress={() => {
                                    setTimeout(() => {
                                        this.props.navigation.navigate('PlaidScreen')

                                    }, 100);
                                }} 
                                style={{padding:10,backgroundColor:'#007bff', fontWeight: 'bold',

                            }}>
                                <Text style={{ color: "#fff" }}>LINK YOUR BANK ACCOUNT</Text>
                            </Button>
                        </CardItem>

                    </TouchableHighlight>
                </Card>

            </ScrollView >
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
        dispatch(action.getAccessToken("dsd"))
      }
    }
  }
  
  export default connect(mapStateToProps, mapDispatchToProps)(DashboardComponent)
  

