import React, { Component } from 'react';
import { StyleSheet, Text, View, Image, TextInput } from 'react-native';
import SimpleInput from '../../components/SimpleInput'

function EmailJoinScreen({ navigation }) {
  return (
    <View style={styles.container}>
          <View style={styles.content}>
              <SimpleInput onSubmitEditing ={() => navigation.navigate('SendEmail')}>
              </SimpleInput>
          </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex:1,
    padding: 10,
    backgroundColor: '#333333',
    justifyContent: 'center',
    alignItems: 'center',
  },
  content:{
      marginBottom:200,
  }
});
export default EmailJoinScreen;