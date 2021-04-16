import React, { useState } from 'react';
import { StyleSheet, Text, View, Image, Button } from 'react-native';
import StartLayout from '../../layouts/StartLayout'
import Fade from 'react-native-fade'
import GlobalStyles, { colorStyle,colorSet } from '../../GlobalStyles'

function CheckAccountScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <StartLayout navigation = {navigation}></StartLayout>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    ...colorStyle.background,
  },
  header: {
    width: '100%',
    height: '35%',
  },
  title: {
    width: '100%',
    height: '30%',
    justifyContent: 'center',
  },
  
  Btn: {
    width: 150,
  }
});
export default CheckAccountScreen;