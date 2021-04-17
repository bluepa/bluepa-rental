import React, { Component } from 'react';
import { StyleSheet, Text, View, Image,Button } from 'react-native';
import EmailCheck from '../../layouts/EmailCheckLayout'
import {colorStyle} from '../../GlobalStyles'
function SendEmailScreen({ navigation }) {
  return (
    <View style={{...colorStyle.background,flex:1}}>
      <EmailCheck navigation ={navigation}></EmailCheck>
    </View>
  );
}

export default SendEmailScreen;