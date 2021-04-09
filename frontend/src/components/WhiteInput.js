import React, { Component } from 'react';
import { StyleSheet, Text, View, TextInput } from 'react-native';

export default class WhiteInput extends Component {
    static defaultProps = {
        description: 'untitled',
    }

    constructor(props) {
        super(props);
    }
    render() {
        return (
            <View style={styles.wrap}>
                <Text style={styles.description}>{this.props.description}</Text>
                <TextInput style={styles.input} />
            </View>
        )
    }
}
const styles = StyleSheet.create({
    wrap: {
        flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center', paddingBottom: 10,
    },
    input: {
        borderColor: '#aaa', width: '70%', height: 35, borderWidth: 1, borderRadius: 5, padding: 5,
    },
    description: {
        fontSize: 15,
    },
});