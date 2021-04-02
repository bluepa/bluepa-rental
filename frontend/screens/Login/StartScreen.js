import React, { Component } from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';
import BasicButton from '../../components/BasicButton';
import LoginDrawer from '../../components/LoginDrawer'


function StartScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <View style={styles.header} />
      <View style={styles.title}>
        <Text style={{ fontSize: 35, color: 'white' }}>후훗{'\n'}블루파-렌탈을{'\n'}시작한다</Text>
      </View>
      <View style={styles.content}>
        <Image
          style={{ height: '100%', width: '100%', resizeMode: 'contain' }}
          source={require('../../assets/start_img.jpg')} />
      </View>
      
      <BasicButton
            buttonColor={'#444'}
            title={'시작하기'}
            onPress={() => navigation.navigate('Join')} />
      
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
    width: '100%',
    height: '5%',
  },
  title: {
    width: '100%',
    height: '30%',
    justifyContent: 'center',
  },
  content: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    paddingBottom: 30,
  },
  footer: {
    width: '100%',
    height: '20%',
  },
  Btn:{
    width: 150,
  }
});
export default StartScreen;