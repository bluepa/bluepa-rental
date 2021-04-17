import React from 'react';
import { StyleSheet, Button, View, Text } from 'react-native';
import {colorSet,colorStyle} from '../../GlobalStyles'
import SigninLayout from '../../layouts/SigninLayout'
function EmailJoinScreen({ navigation }) {
  return (
    <View style={styles.container}>
          <View style={styles.content}>
          <View style={styles.element}>
                <Button
                    color ={colorSet.softGrey}
                    title={'Google로 계속'}
                    onPress={() => alert('확인 버튼')} />
            </View>
            <View style={styles.element}>
                <Button
                    color='#3B5998'
                    title={'Facebook으로 계속'}
                    onPress={() => alert('확인 버튼')} /></View>
            <View style={styles.element}>
                <Button
                    color='#fcd411'
                    title={'Kakao로 계속'}
                    onPress={() => alert('확인 버튼')} /></View>
            <View style={styles.element}>
                <Text style={styles.text} >또는</Text>
            </View>
            <SigninLayout navigation={navigation} onPressBtn={() => {navigation.navigate('SendEmail')}}></SigninLayout>
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
  },
  
  element: {
    padding: 10,
  },
  text:{
    textAlign:'center',
  }
});
export default EmailJoinScreen;