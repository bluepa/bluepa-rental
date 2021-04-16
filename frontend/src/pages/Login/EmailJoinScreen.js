import React, { Component } from 'react';
import { StyleSheet, Button, View, Image, TextInput } from 'react-native';
import BoxInput from '../../components/BoxInput'
import WhiteInput from '../../components/WhiteInput'
import {colorStyle} from '../../GlobalStyles'
import SigninLayout from '../../layouts/SigninLayout'
function EmailJoinScreen({ navigation }) {
  return (
    <View style={styles.container}>
          <View style={styles.content}>
              <SigninLayout></SigninLayout>
          </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    ...colorStyle.background,
    flex:1,
    padding: 10,
    
  },
  content:{
  }
});
export default EmailJoinScreen;