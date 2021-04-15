import React, { Component, useState } from 'react';
import { View, Text, StyleSheet } from 'react-native';
import {fontStyle,colorSet} from '../GlobalStyles';

const StartLayout = () =>{
    return(
        <View>
            <Text style ={styles.title} >블루파렌탈</Text>
            <Text style={styles.subtitle}>우리 동네 렌탈 블루파렌탈</Text>
            <Text style={styles.description}>블루파렌탈은 동네 직거래 마켓이에요.{'\n'}내 동네를 설정하고 시작해보세요</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    title:{
        ...fontStyle.title,
        color:colorSet.theme,
        textAlign:'center',
        justifyContent:'center',
    },
    subtitle:{
        ...fontStyle.medium_bold,
        textAlign:'center',
        justifyContent:'center',
        color:colorSet.defaultBlack,
    },
    description: {
        ...fontStyle.small,
        textAlign:'center',
        justifyContent:'center',
        color: colorSet.defaultBlack,
    },
    footer: {

    },
})
export default StartLayout;