;.dosseg
.model small
.stack
.data
    function dw 0600H

.code
    main proc
        mov ax,@data
        mov ds,ax
        
        mov ax,function
        mov bh,71h
        mov cx,0
        mov dx,184fh
        int 10h
        
        mov ah,4ch
        int 21h
        
    main endp
    end main
    