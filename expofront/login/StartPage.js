import React, {Component} from 'react';
import {StyleSheet, Text, View, Image} from 'react-native';
import CustomButton from './CustomButton';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';


function StartPage({ navigation }) {
  return (
    <View style={styles.container}>
        <View style={styles.header} />
        <View style={styles.title}>
          <Text style={{fontSize:35,color:'white'}}>후훗{'\n'}블루파-렌탈을{'\n'}시작한다</Text>
        </View>
        <View style={styles.content}>
          <Image
            style={{height:'100%',width:'100%',resizeMode:'contain'}}
            source={require('./start_img.jpg')}/>
        </View>
        <View style={styles.footer}>
          <CustomButton
            buttonColor={'#444'}
            title={'회원가입'}
            onPress={() => navigation.navigate('Join')}/>
          <CustomButton
          buttonColor={'#023e73'}
          title={'로그인'}
          onPress={() => navigation.navigate('Login')}
         />
        </View>
      </View>
    );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: 'black',
  },
  header: {
    width:'100%',
    height:'5%',
  },
  title: {
    width:'100%',
    height:'30%',
    justifyContent: 'center',
  },
  content: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    paddingBottom:30,
  },
  footer: {
    width:'100%',
    height:'20%',
  },
});
export default StartPage;