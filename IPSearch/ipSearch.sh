#!/bin/bash
typeset -i a=$1
typeset -i b=$2
typeset -i c=$3
for i in {2..254}    # 0 is non usable, 1 is default gateway, 255 is broadcast
        do
                typeset -i x=$i
                ping -c 1 $a.$b.$c.$x > newFile.txt
                #STR= sed -n '2p' < newFile.txt
          STR="Destination Host Unreachable"
                if grep "$STR" newFile.txt; then
                        echo $a.$b.$c.$x >> ipFile.txt
               echo ""
                fi
                rm newFile.txt
        done

