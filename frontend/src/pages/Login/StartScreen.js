import React, { useState } from 'react';
import { StyleSheet, Text, View, Image, Button } from 'react-native';
import LoginLayout from '../../layouts/LoginLayout'
import Fade from 'react-native-fade'
function StartScreen({ navigation }) {

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <View style={styles.title}>
          <Fade direction="up" visible='true'>
            <Text style={{ fontSize: 25, color: 'white' }}>안녕하세요{'\n'}블루파-렌탈을 시작합니다</Text>
          </Fade>
        </View>
      </View>
      <LoginLayout navigation ={navigation}></LoginLayout>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: '#333333',
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
export default StartScreen;