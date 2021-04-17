import React, { Component } from 'react';
import { StyleSheet, Text, View, TextInput } from 'react-native';

export default class BasicTitle extends Component {
    static defaultProps = {
        width: '100%',
        height: '18%',
        text:'untitled',
    }   

    constructor(props) {
        super(props);
    }
    render() {
        return (
            <View style={styles.title, {width:this.props.width, height:this.props.height}}>
                <Text style={styles.text}>{this.props.text}</Text>
                <View style={styles.border} />
            </View>
        )
    }
}
const styles = StyleSheet.create({
    title: {
        justifyContent: 'center',
    },
    text: {
        fontSize:35,paddingBottom:20,
    },
    border:{
        width: "100%", borderBottomWidth: 0.5, borderColor: '#444' ,

    }
});